# Aplicație specifică unui magazin online 

## Descriere

Reprezintă o aplicație pentru gestionarea unui magazin online. Această aplicație este compusă din 3 microservicii:


:point_right: **Auth**: un microserviciu care este destinat utilizatorilor. Cu ajutorul acestui microserviciu, utilizatorii se pot întregistra, conecta și deconecta

:point_right: **Order**: un microservicu destinat plasării de comenzi de către un utilizator

:point_right: **Product**: un microserviciu destinat produselor din cadrul acestui magazin online

Pentru implementarea si accesarea acestei aplicatii am folosit MySql pentru gestionarea bazei de date, SpringBoot pentru implementarea backendului si AngularJS pentru implementarea frontendului. Aceasta aplicatie se bazeaza pe containerele de Docker.


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
