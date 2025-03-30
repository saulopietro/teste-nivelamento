import zipfile 
import os 

def pdf_to_zip(dataset,file_name,output_zip) :      

    os.makedirs(output_zip, exist_ok=True)

    # Define file paths
    csv_path = os.path.join(output_zip, f"{file_name}.csv")
    zip_path = os.path.join(output_zip, f"{file_name}.zip")

    # Save dataset as CSV
    dataset.to_csv(csv_path, index=False, encoding="utf-8")

    # Compress the CSV into a ZIP file
    with zipfile.ZipFile(zip_path, "w") as zipf:
        zipf.write(csv_path, arcname=f"{file_name}.csv")

    # Optionally, remove the CSV file after compression
    os.remove(csv_path)
    print('Csv transformed in zip')
    return zip_path