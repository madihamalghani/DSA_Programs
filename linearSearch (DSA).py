def linear_search(data,item):
    found=0 # Variable to track if the item is found
    count = 0  # Variable to count occurrences of the item
    size=len(data)
    print(f'Size of data containing items= {size}')
        # Iterate over each element in the array
    for i in range(size):
        if data[i]==item:
            found=1
            count+=1
    # Check if the item was found and print the results
    if(found==1):
        print(f'Item exist {count} times')    
    else:
        print('item does not exists')
# Main part of the program
if __name__ == "__main__":
    data = [50, 47, 11, 3, 19, 81, 72, 56, 19]  # Define the list
    item=int(input('Input the item you want to find: '))
    linear_search(data, item)




