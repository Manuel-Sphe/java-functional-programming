
add = lambda a,b : a + b
sub = lambda a,b : a - b
div = lambda a,b : a / b
mul = lambda a,b : a *b

map = {"+":add, '-':sub, '*':mul,'/':div}

try:
  x = eval(input("Enter the value of x : "))
  y = eval(input("Enter the value of y : "))
  operation = input("Enter the operation [+,-,*,/] : ").strip() # remove any extra space

  try:
    print(map[operation](x,y))
  except KeyError:
    print("Impossible operation")
  except ZeroDivisionError:
    print("Can't Divide by Zero")
except ValueError:
  print("Enter numbers only")
