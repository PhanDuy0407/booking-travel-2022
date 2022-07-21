# -*- coding: utf-8 -*-
"""Untitled24.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1bZTtKv3oeQhfjYE98JOLxZ8Z60RdtAVs
"""

import pandas as pd
import numpy as np

#creat data,input update of file data_collaborative_1 vs rmk
data1 = {'userId': [10]*32,
        'itemId': np.arange(1,33),
         'rating':np.random.randint(0,5,32)
        }
data2 = {10}
df = pd.DataFrame(data1, index=None)
df2= pd.DataFrame(data2, index=None)
#print (df)
#update file data
data=pd.read_csv('/content/data_collaborative_1.csv')
placeInfo=pd.read_csv('/content/rmk.csv')
data=pd.concat([data,df])

placeInfo=pd.concat([placeInfo,df2])

data.to_csv (r'/content/data_collaborative_1.csv', index = None, header=True)
placeInfo.to_csv (r'/content/rmk.csv', index = None, header=True)