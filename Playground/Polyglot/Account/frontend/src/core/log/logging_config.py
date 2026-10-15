import logging.config

LOGGING = {
  "version": 1,
  "formatters": {
    "short": {
      "format": "[%(levelname)s]: %(message)s"
    }
  },
  "handlers": {
    "console": {
      "class": "logging.StreamHandler",
      "formatter": "short"
    }
  },
  "root": {
    "handlers": ["console"],
    "level": "DEBUG"
  }
}

def setup():
  logging.config.dictConfig(LOGGING)