from src.transform_pdf import pdf_to_csv 
from src.transform_columns import columns_alter ,read_csv
from src.transform_zip import pdf_to_zip
from src.save_dataset import save_data
from configs import FILE_DATA ,OUTPUT , OUTPUT_ZIP

FILE_DATA = FILE_DATA 
OUTPUT = OUTPUT 
OUTPUT_ZIP = OUTPUT_ZIP

def pipeline() :
    # transform pdf to csv  
    dataset = pdf_to_csv(FILE_DATA)
   
    # load file csv 
    dataset = read_csv(dataset)

    # apply transformers in columns 'OB' e 'AMB'
    columns_alter(dataset)

    # save data
    save_data(dataset,OUTPUT)

    # transform in zip 
    pdf_to_zip(dataset,'Teste_saulo',OUTPUT_ZIP)

# Run app 
if __name__ == '__main__' : 
    pipeline()
