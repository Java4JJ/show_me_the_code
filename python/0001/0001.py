# 0001:将你的QQ头像（或者微博头像）右上角加上红色的数字，类似于微信未读信息数量那种提示效果。

# 1，图像处理，PIL（Pillow)或者OpenCV，操作图像.
# 2，图像和绘制，使用PIL的ImageDraw和ImageFont模块来在图像上绘制文本和形状。


from PIL import Image, ImageDraw, ImageFont


def add_num(image_path, output_path, number):
    # 打开图片
    img = Image.open(image_path)

    # 创建一个绘图对象
    draw = ImageDraw.Draw(img)

    # 定义字体格式
    font_path = "C:/Windows/Fonts/Arial.ttf"
    font = ImageFont.truetype(font_path, 36)

    # 绘制圆形背景
    radius = 20  # 圆的半径
    x, y = img.size[0] - radius * 2, radius  # 圆的位置
    draw.ellipse((x, y, x + radius * 2, y + radius * 2), fill='red')

    # 在给定位置写入数字
    text_w, text_h = get_text_size(draw, str(number), font=font)
    text_x, text_y = x + (radius * 2 - text_w) / 2, y + (radius * 2 - text_h) / 2
    draw.text((text_x, text_y), str(number), font=font, fill=(255, 255, 255))

    # 保存修改后的图片
    img.save(output_path)


def get_text_size(draw, text, font):
    _, top, right, bottom = draw.textbbox((0, 0), text, font=font)
    width = right - 0
    height = bottom - top
    return (width, height)


# 未读消息数量
number = 9
# 图片路径
image_path = 'D:/sspace/image/head_img.jpg'
# 图片输出路径
output_path = 'D:/sspace/image/head_img_1.jpg'

add_num(image_path, output_path, number)
