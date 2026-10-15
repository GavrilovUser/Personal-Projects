from core import log # noqa: 401 – Настройка логов

import asyncio

from aiogram import Bot, Dispatcher
from aiogram.filters import CommandStart
from aiogram.types import Message

from handlers.start import router as start_router
from callbacks.users import router as users_callbacks_router
from states.users import router as users_states_router

from config import settings

async def main():
  bot = Bot(settings.BOT_TOKEN)
  dispatcher = Dispatcher()

  dispatcher.include_router(start_router)
  dispatcher.include_router(users_callbacks_router)
  dispatcher.include_router(users_states_router)
  
  await dispatcher.start_polling(bot)
  
if __name__ == "__main__":
  asyncio.run(main())