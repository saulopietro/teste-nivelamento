import pdfplumber
import pandas as pd 
import io

def pdf_to_csv(pdf_path):
    """
        Converts tables from a PDF file to a CSV file.

        This function extracts tables from all pages of a PDF and converts them into a pandas DataFrame, 
        which is then saved as a CSV file.

        Parameters:
        pdf_path (str): Path to the input PDF file.
        csv_path (str): Path to the output CSV file.

        Example usage:
        pdf_to_csv("document.pdf", "tables.csv") 
    """
    tables = []
    
    with pdfplumber.open(pdf_path) as pdf:
        for page in pdf.pages:
            table = page.extract_table()
            if table:
                tables.extend(table)
    
    df = pd.DataFrame(tables[1:], columns=tables[0])  
    csv_buffer = io.BytesIO()
    
    df.to_csv(csv_buffer, index=False, encoding="utf-8")
    

    csv_buffer.seek(0)
    
    return csv_buffer
