from aiogram import Router
from aiogram.filters import CommandStart
from aiogram.types import Message
from aiogram.types import FSInputFile

from pathlib import Path

from aiogram.utils.keyboard import InlineKeyboardBuilder

from api.client import get_accounts, get_accounts_amount

router = Router(name=__name__)

@router.message(CommandStart())
async def cmd_start(message: Message) -> None:
  BASE_DIR = Path(__file__).resolve().parent
  PREVIEW_DIR = BASE_DIR.parents[2] / "image" / "preview.png"
  
  builder = InlineKeyboardBuilder()
  
  main_menu_ui = [
    f"<b>Всего аккаунтов: {await get_accounts_amount()}</b>"
  ]

  for account in await get_accounts():
    main_menu_ui.append(f"[ID {account['id']}] – {account['name']}")

  builder.button(text="Новый аккаунт", callback_data="new_account")
  builder.button(text="Управление", callback_data="account_settings")

  builder.adjust(2)

  await message.answer_photo(FSInputFile(PREVIEW_DIR), caption='\n'.join(main_menu_ui), parse_mode="HTML", reply_markup=builder.as_markup())