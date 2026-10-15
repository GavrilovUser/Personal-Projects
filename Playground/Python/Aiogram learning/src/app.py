import core.logging_setup # noqa: F401 – Настраивает логирование

import asyncio
from aiogram import Bot, Dispatcher
from aiogram.filters import Command
from aiogram.types import Message

from inline.buttons import buttons_router
from inline.callback import callback_router

from config import BOT_TOKEN

bot = Bot(BOT_TOKEN)
dispatcher = Dispatcher()

dispatcher.include_router(buttons_router)
dispatcher.include_router(callback_router)

async def main():
  await dispatcher.start_polling(bot)

if __name__ == "__main__":
  asyncio.run(main())