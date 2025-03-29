import pandas as pd 

def read_csv(file_csv) : 
    """
    Reads a CSV file into a pandas DataFrame.

    This function loads a CSV file into a pandas DataFrame using a comma (',') as the separator.

    Parameters:
    file_csv (str): Path to the CSV file.

    Returns:
    pd.DataFrame: A DataFrame containing the CSV data.

    Example usage:
    df = read_csv("data.csv")
    """
    dataset = pd.read_csv(file_csv,sep=',')
    print('File csv read...')
    return dataset

def columns_alter(dataset) -> pd.DataFrame: 
    """
    Renames specific columns in a pandas DataFrame.

    This function renames the columns "OD" and "AMB" to more descriptive names.

    Parameters:
    dataset (pd.DataFrame): The DataFrame whose columns need to be renamed.

    Returns:
    pd.DataFrame: The updated DataFrame with renamed columns.

    Example usage:
    df = columns_alter(df)
    """
    dataset.rename(
            columns = {'OD': 'Seg. Odontológica',
                    'AMB': 'Seg. Ambulatorial'},
            inplace=True
    )
