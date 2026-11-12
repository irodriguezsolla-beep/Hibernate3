package FileServices;
import Models.Adestrador;
import Models.Pokedex;
import Models.Pokemon;


import javax.xml.stream.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FileServices {
    public static void Pokedex(List<Pokedex> listapokedex, String ruta) {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeStartElement("Pokedex");
            xsw.writeCharacters("\n");
            for (Pokedex p : listapokedex) {
                xsw.writeCharacters("  ");
                xsw.writeStartElement("Pokemon");
                xsw.writeAttribute("id", String.valueOf(p.getId()));
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Nome");
                xsw.writeCharacters(p.getNome() != null ? p.getNome() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Peso");
                xsw.writeCharacters(String.valueOf(p.getPeso()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Misc");
                xsw.writeCharacters(p.getMisc() != null ? p.getMisc() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");


                xsw.writeCharacters("  ");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");
            }

            xsw.writeEndElement();
            xsw.writeCharacters("\n");
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();
            fw.close();
            System.out.println("Arquivo XML xerado correctamente en: " + ruta);
        } catch (Exception e) {
            System.err.println("Erro : " + e.getMessage());
        }
    }

    public static void Adestrador(List<Adestrador> listaadestrador, String ruta) {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeStartElement("Adestrador");
            xsw.writeCharacters("\n");
            for (Adestrador a : listaadestrador) {
                xsw.writeCharacters("  ");
                xsw.writeStartElement("Adestrador");
                xsw.writeAttribute("id", String.valueOf(a.getId()));
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Nome");
                xsw.writeCharacters(a.getNome() != null ? a.getNome() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Data");
                xsw.writeCharacters(String.valueOf(a.getNacemento()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");


                xsw.writeCharacters("  ");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");
            }

            xsw.writeEndElement();
            xsw.writeCharacters("\n");
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();
            fw.close();
            System.out.println("Arquivo XML xerado correctamente en: " + ruta);
        } catch (Exception e) {
            System.err.println("Erro : " + e.getMessage());
        }
    }

    public static void Pokemon(List<Pokemon> listapokemon, String ruta) {
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try {
            FileWriter fw = new FileWriter(ruta);
            XMLStreamWriter xsw = xof.createXMLStreamWriter(fw);
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeStartElement("Adestrador");
            xsw.writeCharacters("\n");
            for (Pokemon a : listapokemon) {
                xsw.writeCharacters("  ");
                xsw.writeStartElement("Pokemon");
                xsw.writeAttribute("id", String.valueOf(a.getId()));
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Nome");
                xsw.writeCharacters(a.getNome() != null ? a.getNome() : "");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Data");
                xsw.writeCharacters(String.valueOf(a.getNacemento()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("PokedexEntry");
                xsw.writeCharacters(String.valueOf(a.getPokedexEntry()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("    ");
                xsw.writeStartElement("Adestrador");
                xsw.writeCharacters(String.valueOf(a.getAdestrador()));
                xsw.writeEndElement();
                xsw.writeCharacters("\n");

                xsw.writeCharacters("  ");
                xsw.writeEndElement();
                xsw.writeCharacters("\n");
            }

            xsw.writeEndElement();
            xsw.writeCharacters("\n");
            xsw.writeEndDocument();

            xsw.flush();
            xsw.close();
            fw.close();
            System.out.println("Arquivo XML xerado correctamente en: " + ruta);
        } catch (Exception e) {
            System.err.println("Erro : " + e.getMessage());
        }
    }

    //serial
    public static void SerialPokedex(Pokedex p) {

        try (FileOutputStream FoS = new FileOutputStream("serial-Pokedex", true);
             ObjectOutputStream OoS = new ObjectOutputStream(FoS)) {

            OoS.writeObject(p);
            System.out.println("Guardado en serial");
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public static void SerialAdestrador(Adestrador a) {

        try (FileOutputStream FoS = new FileOutputStream("serial-Adestrador", true);
             ObjectOutputStream OoS = new ObjectOutputStream(FoS)) {

            OoS.writeObject(a);
            System.out.println("Guardado en serial");
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public static void SerialPokemon(Pokemon p) {

        try (FileOutputStream FoS = new FileOutputStream("serial-Pokemon", true);
             ObjectOutputStream OoS = new ObjectOutputStream(FoS)) {

            OoS.writeObject(p);
            System.out.println("Guardado en serial");
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    //Deserializar
    public static List<Pokedex> DeserializaPokedex(String ruta) {
        File file = new File(ruta);

        List<Pokedex> p = null;
        try (FileInputStream FiS = new FileInputStream(file);
             ObjectInputStream OiS = new ObjectInputStream(FiS)) {

            p = (List<Pokedex>) OiS.readObject();
            System.out.println("Guardado en serial");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error" + e);
        }
        return p;
    }

    //exportar xml
    public static List<Adestrador> importarAdestrador(String ruta) {
        List<Adestrador> lista = new ArrayList<>();
        XMLInputFactory xif = XMLInputFactory.newInstance();

        try (FileReader fr = new FileReader(ruta)) {
            XMLStreamReader xsr = xif.createXMLStreamReader(fr);
            Adestrador actual = null;
            StringBuilder texto = new StringBuilder();

            while (xsr.hasNext()) {
                int evento = xsr.next();

                switch (evento) {
                    case XMLStreamConstants.START_ELEMENT:
                        texto.setLength(0);
                        if ("Adestrador".equals(xsr.getLocalName())) {
                            // Diferencia el <Adestrador id="..."> hijo del <Adestrador> raíz
                            String idAttr = xsr.getAttributeValue(null, "id");
                            if (idAttr != null) {
                                actual = new Adestrador();
                                actual.setId(Long.parseLong(idAttr));
                            }
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        texto.append(xsr.getText());
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        String etiqueta = xsr.getLocalName();

                        if (actual != null) {
                            if ("Nome".equals(etiqueta)) {
                                actual.setNome(texto.toString().trim());
                            } else if ("Data".equals(etiqueta)) {
                                String fechaStr = texto.toString().trim();
                                if (!fechaStr.isEmpty() && !"null".equals(fechaStr)) {
                                    actual.setNacemento(parsearFecha(fechaStr));
                                }
                            } else if ("Adestrador".equals(etiqueta)) {
                                lista.add(actual);
                                actual = null;
                            }
                        }
                        break;
                }
            }
            xsr.close();
        } catch (Exception e) {
            System.err.println("Erro ao importar XML: " + e.getMessage());
        }

        return lista;
    }
    private static Date parsearFecha(String fechaStr) throws Exception {
        if (fechaStr.matches("\\d{4}-\\d{2}-\\d{2}.*")) {
            // Cubre tanto "yyyy-MM-dd" como timestamps "yyyy-MM-dd HH:mm:ss.0"
            return java.sql.Date.valueOf(fechaStr.substring(0, 10));
        }
        // Por si String.valueOf() exportó el formato por defecto de java.util.Date
        return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(fechaStr);
    }
}



