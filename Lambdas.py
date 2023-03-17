map = {'+':lambda a,b : a + b, '-':lambda a,b : a - b, '*':lambda a,b : a *b,'/':lambda a,b : a / b}
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
