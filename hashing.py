import hashlib

password  = input("Emter your password: \n->")
passw = "password123"

hash_pass = hashlib.sha1(bytes(password,"ascii"))
hex_pass = hash_pass.hexdigest()

print("Your hash",hex_pass)

hash_object = hashlib.sha1(bytes(passw,"ascii"))
hex_dig = hash_object.hexdigest()

Fake_DB = [hex_dig]

if hex_pass in Fake_DB:
    print("Logged in ..........")
else:   
    print("Sorry Wrong password")
print("Actual hash",hex_dig)
