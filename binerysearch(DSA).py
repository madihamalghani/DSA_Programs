class BSearch:
    #self is a reference to the instance of the class that is used to access the class attributes and methods within the class. It allows each method to operate on the instance of the class that called it.
    def binary_search(self,data,item):
        lb=0 # Lower bound
        ub=len(data)-1 #upper bond 
        #for len(data)=total elements in array =8 last index=8-1=7
        while lb <= ub:
            mid=(lb+ub)//2
            if data[mid]==item:
                print(f'Item exists {item} at position {mid}')
                return
            # If the item is greater than the mid element, search the right half
            elif item>data[mid]: #elif=>else if
                lb=mid+1
            # If the item is smaller than the mid element, search the left half
            else:
                ub=mid-1
            # If the loop ends without finding the item
        print("Item does not exist")            

# Create an instance of BSearch

bsearch = BSearch()
# Define the sorted array
data=[10,20,30,40,60,70,80,90,100]
item = int(input("Enter the item you want to search: "))
bsearch.binary_search(data, item)




