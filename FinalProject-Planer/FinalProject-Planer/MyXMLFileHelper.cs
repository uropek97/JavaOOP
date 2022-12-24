using System.Xml.Serialization;

namespace FinalProject_Planer
{
    public class MyXMLFileHelper : IMyFileHelper
    {
        private FileInfo file = new FileInfo("planer.txt");

        public XmlSerializer? Xml = new XmlSerializer(typeof(Planer));
        public string Read(string fileName)
        {
            throw new NotImplementedException();
        }

        public void Write(string data, string fileName)
        {
            throw new NotImplementedException();
        }
    }
}
