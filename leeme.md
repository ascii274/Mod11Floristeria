# ###################################
# Class ProductesController.java ( model.controller ) o millo FloristeriaController.java
# ###################################

- propietats
 FloristeriaRepository floristeriaRepository;

Métodes:
- crearFloristeria:void
- afegirArbre:void
- afegirFlor:void
- afegirDecoracio:void
- mostrarDades:String


# ###################################
# Class PanellControl.java ( en model.view)
# ###################################
- Dibujar Frame
    :Etiqueta exemples stock (capçalera )
    : 3 botons ( mostraArbres, mostrarDecoracio i mostrarFlors)
    : 3 etiquetas ( aqui es mostra les dades )


- metodes onclick del tres botons que mostra les dades a les etiquetes.


# ###################################
# Class FloristeriaRepository.java ( en model.persistance )
# ###################################

- propietats:
    List<Productes> productes =new ArrayList<>();

- metodes:
    afegirProducte(Producte producte)
    getter:List


