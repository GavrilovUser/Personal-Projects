from aiogram.types import Message
from aiogram import Router, F
from aiogram.filters import StateFilter
from aiogram.fsm.context import FSMContext

from api.client import new_account

router = Router(name=__name__)

@router.message(StateFilter("new_account_name"), F.text)
async def get_account_name(message: Message, state: FSMContext):
  name = message.text
  await state.clear()

  await new_account(name)
  await message.answer(text=f"Аккаунт [{name}] создан, /start")