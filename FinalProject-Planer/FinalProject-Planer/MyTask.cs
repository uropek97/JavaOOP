namespace FinalProject_Planer
{
    public class MyTask
    {
        private string? name;
        private DateTime creationDate;
        private bool ifUrgent = false;

        public string? Name { get { return name; } set { name = value; } }
        public DateTime CreationDate { get { return creationDate; } set { creationDate = value; } }
        public bool IfUrgent { get { return ifUrgent; } set { ifUrgent = value; } }
        public MyTask()
        {
            this.CreationDate = DateTime.Now;
        }
        public MyTask(string? name) : this()
        {
            this.name = name;
        }

        public override string ToString()
        {
            return this.Name!.ToString();
        }
    }
}
