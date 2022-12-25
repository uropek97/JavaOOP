using FinalProject_Planer;
using System.Xml.Serialization;

if (!File.Exists("planer.xml"))
{
    File.Create("planer.xml");
    Planer planer = new Planer();
    XmlSerializer xml = new XmlSerializer(typeof(Planer));
    using(var fs = new FileStream("planer.xml", FileMode.Open, FileAccess.Write))
    {
        xml.Serialize(fs, planer);
    }
}

var presenter = new Presenter(new ConsoleInterface(), new MyXMLFileHelper());
presenter.Work();