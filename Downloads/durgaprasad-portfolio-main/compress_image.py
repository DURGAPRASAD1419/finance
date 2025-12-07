from PIL import Image

# Open the image
img = Image.open('farmexpert.jpg')

# Resize the image to reduce file size
img.thumbnail((800, 600), Image.Resampling.LANCZOS)

# Save with reduced quality
img.save('farmexpert.jpg', 'JPEG', quality=85, optimize=True)

print("Image compressed successfully!")
