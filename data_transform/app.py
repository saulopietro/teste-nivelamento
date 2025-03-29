from src.transform_pdf import pdf_to_csv 
from src.transform_columns import columns_alter ,read_csv
from src.transform_zip import pdf_to_zip
from configs import FILE_DATA ,OUTPUT , OUTPUT_ZIP

FILE_DATA = FILE_DATA 
OUTPUT = OUTPUT + '/data.csv'
OUTPUT_ZIP = OUTPUT_ZIP

def pipeline() :
    # transform pdf to csv  
    pdf_to_csv(FILE_DATA,OUTPUT)

    # load file csv 
    dataset = read_csv(OUTPUT)

    # apply transformers in columns 'OB' e 'AMB'
    columns_alter(dataset)

    # transform in zip 
    pdf_to_zip(dataset,'dataset',OUTPUT_ZIP)

# Run app 
if __name__ == '__main__' : 
    pipeline()








