from aiogram import Router
from aiogram.filters import Command
from aiogram.types import Message
from aiogram.types import InlineKeyboardMarkup, InlineKeyboardButton
from aiogram.utils.keyboard import InlineKeyboardBuilder

buttons_router = Router(name=__name__)
builder = InlineKeyboardBuilder()

button_1 = InlineKeyboardButton(text="кнопка 1", callback_data="btn:1")
button_2 = InlineKeyboardButton(text="кнопка 2", callback_data="btn:2")

for i in range(1, 11):
  builder.button(
    text=f"Кнопка {i}",
    callback_data=f"btn:{i}"
  )

keyboard_1 = InlineKeyboardMarkup(
  inline_keyboard=[
    [button_1, button_2]
  ]
)

builder.adjust(2, 2)
keyboard_2 = builder.as_markup()

@buttons_router.message(Command("start"))
async def echo_handler(message: Message):
  await message.answer(text="Кнопки константные", reply_markup=keyboard_1)
  await message.answer(text="Кнопки билдера", reply_markup=keyboard_2)