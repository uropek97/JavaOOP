namespace FinalProject_Planer
{
    public class MyTask
    {
        private string? name;
        private DateTime creationDate;
        private bool ifDone;

        public string? Name { get { return name; } set { name = value; } }
        public DateTime CreationDate { get { return creationDate; } set { creationDate = value; } }
        public bool IfDone { get { return ifDone; } set { ifDone = value; } }
        public MyTask()
        {
            this.CreationDate = DateTime.Now;
            IfDone = false;
        }
        public MyTask(string? name) : this()
        {
            this.name = name;
        }

        public void Finish()
        {
            this.IfDone = true;
        }

        public override string ToString()
        {
            if (this.ifDone)
                return $"[ ] {this.Name!.ToString()}";
            else
                return $"[x] {this.Name!.ToString()}";
        }
    }
}
