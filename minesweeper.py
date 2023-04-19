from typing import List
grid : List[ List[str] ] =[
        ["-","-","-","#","#"],
        ["-","#","-","-","-"],
        ["-","-","#","-","-"],
        ["-","#","#","-","-"],
        ["-","-","-","-","-"]
        
       ]


rows : int  = 5
cols : int = 5


for i in range(rows):
    for j in range(cols):
        
        if grid[i][j] == "#": # if a mine the ignore 
            continue
        
        # Given a pair (x,y) check all the neighors and updatet the count
        count : int  = 0
        for x in range(max(0,i - 1),min(rows, i + 2 )): # 0, 0 row + 2 = row + 1
            for y in range(max(0,j - 1), min(cols ,j + 2)):
                if(grid[x][y] == "#"):  # find a neigbhour mine 
                    count += 1 
        grid[i][j] = str(count)
                
print(grid)
