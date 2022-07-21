# -*- coding: utf-8 -*-
"""Untitled24.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1bZTtKv3oeQhfjYE98JOLxZ8Z60RdtAVs
"""
#creat random user
import pandas as pd
import numpy as np
data1 = {'userId': [10]*32,
        'itemId': np.arange(1,33),
         'rating':np.random.randint(0,5,32),
         'isvisited':0*32
        }
data1 = pd.DataFrame(data1, index=None)
for i in range(32):
  if data1['rating'][i]>0:
     data1['isvisited'][i]=1
  else: 
    data1['isvisited'][i]=np.random.choice(np.arange(0,2), p=[0.85,0.15])

print (data1)
#update file data
data=pd.read_csv('/content/data_collaborative_1.csv')
data=pd.concat([data,data1])
print(data)
data.to_csv (r'/content/data_collaborative_1.csv', index = None, header=True)
