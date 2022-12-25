namespace FinalProject_Planer
{
    public class Planer
    {
        private List<MyTask>? _Tasks;
        private List<MyPurpose>? _Purposes;
        public List<MyTask>? Tasks { get { return _Tasks; } set { _Tasks = value; } }
        public List<MyPurpose>? Purposes { get { return _Purposes; } set { _Purposes = value; } }


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

        public void RemoveTask(string name)
        {
            if (this.Tasks!.Contains(new MyTask(name)))
            {
                this.Tasks.Remove(new MyTask(name));
            }
        }

        public void RemovePurpuse(string name)
        {
            if (this.Purposes!.Contains(new MyPurpose(name)))
            {
                this.Purposes!.Remove(new MyPurpose(name));
            }
        }
    }
}
