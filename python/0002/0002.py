# **0002**:   为你的应用生成激活码（或者优惠券），如何生成 200 个激活码（或者优惠券）？

# 1：激活码唯一性 用一个set存储，生产一个后判断是否存在，来解决唯一性
# 2：激活码长度，包含字母，数字。 长度越长，唯一性的可能越高
# 3：激活码的安全性，主要是随机函数和长度

import random
import string


def create_code():
    total = 200
    # 1234-1234-1234格式
    result = set()

    # 可以用于激活码的字符集
    chars = string.ascii_letters + string.digits
    while len(result) < total:
        part1 = "".join(random.choices(chars, k=4))
        part2 = "".join(random.choices(chars, k=4))
        part3 = "".join(random.choices(chars, k=4))
        code = "-".join([part1, part2, part3])
        if code in result:
            continue
        else:
            result.add(code)

    return result


print(create_code())
