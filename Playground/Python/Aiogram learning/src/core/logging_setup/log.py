import logging
from logging import config

LOGGING = {
  "version": 1,
  "disable_existing_loggers": False,
  "formatters": {
    "standard": {
      "format": "%(asctime)s - [%(levelname)s] [%(name)s]: %(message)s",
      "datefmt": "%Y-%m-%d %H:%M:%S"
    }
  },
  "handlers": {
    "console": {
      "class": "logging.StreamHandler",
      "formatter": "standard"
    }
  },
  "root": {
    "handlers": ["console"],
    "level": "DEBUG"
  }
}

def setup(level: str = 'DEBUG'):
  logging.config.dictConfig(LOGGING)