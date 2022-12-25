using System.Xml.Serialization;

namespace FinalProject_Planer
{
    public class MyXMLFileHelper : IMyFileHelper
    {
        private static string fileName = "planer.xml";

        private XmlSerializer? _Xml;

        public XmlSerializer? Xml { get { return _Xml; } private set { _Xml = new XmlSerializer(typeof(Planer)); } }

        public Planer Read()
        {
            using(var fs = new FileStream(fileName, FileMode.Open, FileAccess.Read))
            {
                return (Planer)this.Xml!.Deserialize(fs)!;
            }
        }

        public void Write(Planer planer)
        {
            using(var fs = new FileStream(fileName, FileMode.Open, FileAccess.Write))
            {
                this.Xml!.Serialize(fs, planer);
            }
        }
    }
}
