package XML;
import Models.Adestrador;
import Models.Pokedex;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.util.List;

public class toXML {
    public static void Pokedex(List<Pokedex> listapokedex, String ruta){
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try{
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
        }catch (Exception e){
            System.err.println("Erro : " + e.getMessage());
        }
    }

    public static void Adestrador(List<Adestrador> listaadestrador, String ruta){
        XMLOutputFactory xof = XMLOutputFactory.newInstance();
        try{
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
        }catch (Exception e){
            System.err.println("Erro : " + e.getMessage());
        }
    }
}
