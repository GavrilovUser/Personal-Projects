import asyncio
import aiohttp

import logging

async def get_accounts_amount() -> int:
  async with aiohttp.ClientSession() as session:
    async with session.get(f'http://127.0.0.1:8080/users') as response:
      content = await response.json()
      return len(content)

async def get_accounts() -> list:
  async with aiohttp.ClientSession() as session:
    async with session.get(f'http://127.0.0.1:8080/users') as response:
      content = await response.json()
      return content

async def get_account(id: int) -> list:
  async with aiohttp.ClientSession() as session:
    async with session.get(f'http://127.0.0.1:8080/users/{id}') as response:
      content = await response.json()
      return content

async def new_account(account_name: str) -> dict:
  async with aiohttp.ClientSession() as session:
    async with session.post(
      'http://127.0.0.1:8080/users',
      json={
        "name": account_name
      }
    ) as response:
      content = await response.json()
      return content

async def delete_account(id: int) -> bool:
  async with aiohttp.ClientSession() as session:
    async with session.post(
      f'http://127.0.0.1:8080/users/{id}/delete'
    ) as response:
      content = await response.json()
      return content