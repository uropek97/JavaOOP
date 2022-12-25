namespace FinalProject_Planer
{
    public class MyPurpose
    {
        private string? name;
        private List<MyTask>? tasks;
        private DateTime creationDate;
        private bool ifDone;

        public string? Name { get { return name; } set { name = value; } }
        public List<MyTask>? Tasks { get { return tasks; } set { tasks = value; } }
        public DateTime CreationDate { get { return creationDate; } set { creationDate = value; } }
        public bool IfDone { get { return ifDone; } set { ifDone = value; } }

        public MyPurpose() 
        {
            this.Tasks = new List<MyTask>();
            this.CreationDate = DateTime.Now;
            this.IfDone = false;
        }

        public MyPurpose(string? name) : this()
        {
            this.Name = name;           
        }

        public void CreateTask(string? name)
        {
            this.Tasks!.Add(new MyTask(name));
        }


        public override string ToString()
        {
            return this.Name!.ToString();
        }
    }
}
