import os 
def save_data(dataset, path_data): 
    if not os.path.exists(path_data):
        os.makedirs(path_data)
    
    path = os.path.join(path_data, "dataset.csv")
    
    dataset.to_csv(path, index=False)
    
    print(f"Saved file: {path}")