namespace FinalProject_Planer
{
    public class Planer
    {
        private List<MyTask>? tasks;
        private List<MyPurpose>? purposes;
        public List<MyTask>? Tasks { get { return tasks; } private set { tasks = value; } }
        public List<MyPurpose>? Purposes { get { return purposes; } private set { purposes = value; } }


        public Planer()
        {
            this.Tasks = new List<MyTask>();
            this.Purposes = new List<MyPurpose>();
        }

        public MyTask CreateNewTask(string name)
        {
            var a = new MyTask(name);
            this.Tasks!.Add(a);
            return a;
        }

        public MyPurpose CreateNewPurpose(string name)
        {
            var a = new MyPurpose(name);
            this.Purposes!.Add(a);
            return a;
        }

        public void AddTask(MyTask task)
        {
            this.Tasks!.Add(task);
        }
        public void AddPurpose(MyPurpose purpose)
        {
            this.Purposes!.Add(purpose);
        }
    }
}
