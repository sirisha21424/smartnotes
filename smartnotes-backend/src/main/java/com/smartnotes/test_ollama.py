import ollama

try:
    print("Ollama library imported successfully!")
    print(f"Ollama version: {ollama.__version__}")
except ImportError:
    print("Ollama library not found.")