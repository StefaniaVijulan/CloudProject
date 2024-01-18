# Aplicație specifică unui magazin online 

## Descriere

Reprezintă o aplicație pentru gestionarea unui magazin online. Această aplicație este compusă din 3 microservicii:

:point_right: **Auth**: un microserviciu care este destinat utilizatorilor. Cu ajutorul acestui microserviciu, utilizatorii se pot întregistra, conecta și deconecta

:point_right: **Order**: un microservicu destinat plasării de comenzi de către un utilizator

:point_right: **Product**: un microserviciu destinat produselor din cadrul acestui magazin online


Cele 3 microservicii comunica intre ele cu ajutorului frontendului si a bazei de date comune. 
Astfel, in cadrul aplicatiei vom putea observa doua pagini principale, ce sunt accesibile doar atunci cand userul nu este conectat, pagina de login si register. Odata ce userul a reusit sa se conecteze cu succes acesta va avea 3 pagini. Prima pagina este pagina de *Product*, in care userul poate sa adauge un nou produs in cadrul magazinului, dar si o noua categorie din care produsul poate face parte. Tot in cadrul acestei pagini vom putea adauga un produs la comanda apasand butonul de "Add product". O data ce toate produsele au fost selectate, userul va putea accesa pagina de *Order*, unde va vedea mai multe detalii despre comanda, inclusiv lista de produse aflate in microserviciu "Product" adaugate pentru realizare comenzii. Dupa ce comanda a fost adaugata, clientul va avea posibilitatea de a vedea lista de produse in pagina *Profile* unde va vedea atat informatii cu vedere la profilul sau, cat si lista tuturor comenziilor plasate de catre acesta.

Pentru implementarea si accesarea acestei aplicatii am folosit:

:small_blue_diamond: MySql pentru gestionarea bazei de date

:small_blue_diamond: SpringBoot pentru implementarea backendului 

:small_blue_diamond: AngularJS pentru implementarea frontendului. Aceasta aplicatie se bazeaza pe containerele de Docker.


## Rularea aplicatiei

Pentru pornirea containerelor de docker ne-am folosit de Docker compose. 

```
  docker compose up --build
```

Pentru accesarea si folosirea aplicatiei:
```
   http://localhost:4200/
```


Pentru accesarea Zipkinului accesati ruta:

```
  http://localhost:9411/
```
