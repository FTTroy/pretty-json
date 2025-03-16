document.getElementById('phrasebutton').addEventListener('click', function() {
        const choice = document.getElementById('choice').value;
   fetch('/phrase-controller/generate-phrase?reason=' + choice)
           .then(response => response.text())
           .then(data => {
               document.getElementById('message').textContent = data;
           })
           .catch(error => console.error('error:', error));
});

document.getElementById('downloadbutton').addEventListener('click', function() {
             var link = document.createElement('a');
                        link.href = '/excel-controller/download-excel';  // URL dell'API che restituisce l'Excel
                        link.download = 'report.xlsx';     // Imposta il nome del file da scaricare

                        // Simula un click sul link per avviare il download
                        link.click();
});