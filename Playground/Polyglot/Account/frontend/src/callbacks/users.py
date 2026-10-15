from aiogram import Router, F
from aiogram.types import CallbackQuery
from aiogram.fsm.context import FSMContext

from aiogram.utils.keyboard import InlineKeyboardBuilder

from api.client import get_accounts, get_account, delete_account

router = Router(name=__name__)

@router.callback_query(F.data == "new_account")
async def cmd_new_account(callback: CallbackQuery, state: FSMContext):
  await callback.message.answer("Напиши имя аккаунта")
  await state.set_state("new_account_name")
  await callback.answer()

@router.callback_query(F.data == "account_settings")
async def cmd_account_settings(callback: CallbackQuery):
  builder = InlineKeyboardBuilder()

  for account in await get_accounts():
    builder.button(text=f"{account['name']} [ID {account['id']}]", callback_data=f"account_{account['id']}")

  builder.adjust(1)
  
  await callback.message.answer("<b>Выбери аккаунт</b>", reply_markup=builder.as_markup(), parse_mode="HTML")
  await callback.answer()

@router.callback_query(F.data.startswith("account_"))
async def cmd_account_settings(callback: CallbackQuery):
  builder = InlineKeyboardBuilder()
  
  account_id = callback.data.split("_", 1)[1]
  account = await get_account(account_id)

  account_settings_ui = [
    f"<b>{account['name']}</b>",
    f"ID: {account['id']}"
  ]

  builder.button(text="удалить", callback_data=f"delete_account_{account['id']}")

  await callback.message.answer('\n'.join(account_settings_ui), parse_mode="HTML", reply_markup=builder.as_markup())
  await callback.answer()

@router.callback_query(F.data.startswith("delete_account_"))
async def cmd_delete_account(callback: CallbackQuery):
  account_id = callback.data.split("delete_account_", 1)[1]
  response = await delete_account(account_id)
  if response:
    await callback.message.answer(text="Аккаунт удалён, /start")
  else:
    await callback.message.answer(text="Не удалось удалить аккаунт")
  await callback.answer()