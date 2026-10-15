import logging

from aiogram import Router
from aiogram import F
from aiogram.types import CallbackQuery

logger = logging.getLogger(__name__)
callback_router = Router(name=__name__)

@callback_router.callback_query(F.data.startswith("btn:"))
async def btn_1(callback: CallbackQuery):
  btn_index = callback.data.split(":")[1]
  
  await callback.answer()
  await callback.message.edit_text(
    text=f"Кнопки билдера\nКнопка {btn_index}",
    reply_markup=callback.message.reply_markup
  )