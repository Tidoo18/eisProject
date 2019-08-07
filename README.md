# eisProject
# Užduotis
-Išanalizuoti kokią informaciją apie valiutų kurs galima gauti iš LBank.lt ir kaip veikia
užklausos parametrai.
-Sukurti programą, kuri galėtų parsiųsti valiutų kursus pagal:
nurodytas datas arba periodą (nuo, iki)
nurodytų valiutų kodus.
-Programa turi pateikti nurodytų valiutų kursus ir suskaičiuoti valiutos kurso pokytį nuo
periodo pradžios iki periodo pabaigos.
-Duomenų saugojimas nebūtinas.
# Programos apibūdinimas
Programa turi 3 klases. 
Main - Paleidimui(sukuriamas objektas ir paleidžiama klasė). 
Currency - turi Meniu mechanizma. Taip pat tikrina valiutas ir datas.
CurrencyDownloadAndRead - nustato url. Atsisiunčia XML Dokumenta ir jį skaito(atspausdinant informacija), taip pat rodo valiutos skirtumus.
Analize.txt yra nurodyti kaikurie šaltiniai(nenorėjau dėti visų puslapiu iš stackoverflow).
# Programa paleidimas
Paleidžiama per console(main klasė).
Paleidžiama per komandine eilute (java jar eisCurrencys.jar).
# Trūkumai
Programa tikrina kursą tik iš EUR.(Rytoj pataisysių).
Programoje trūksta klaidų sugaudimo. (Rytoj pataisysių).
Programoje trūksta testų. (Rytoj pataisysių).
Programa turi kelis trūkumus menių dalyje. (Rytoj pataisysių).
Programa galėtu turėti UI.
