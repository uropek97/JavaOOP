namespace FinalProject_Planer
{
    public class MyPurpose
    {
        private string? name;
        private List<MyTask>? tasks;

        public string? Name { get { return name; } set { name = value; } }
        public List<MyTask>? Tasks { get { return tasks; } set { tasks = value; } }

        public MyPurpose() { }

        public MyPurpose(string? name)
        {
            this.Name = name;
            this.Tasks = new List<MyTask>();
        }

        public MyPurpose(string? name, MyTask myTask) : this(name)
        {
            this.Tasks!.Add(myTask);
        }

        public MyPurpose(string? name, List<MyTask> myTasks) : this(name)
        {
            this.Tasks!.AddRange(myTasks);
        }

        public override string ToString()
        {
            return this.Name!.ToString();
        }
    }
}
