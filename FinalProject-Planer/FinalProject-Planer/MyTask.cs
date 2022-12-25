namespace FinalProject_Planer
{
    public class MyTask : IEquatable<MyTask>
    {
        private string? _Name;
        private DateTime _CreationDate;
        private bool _IfDone;

        public string? Name { get { return _Name; } set { _Name = value; } }
        public DateTime CreationDate { get { return _CreationDate; } set { _CreationDate = value; } }
        public bool IfDone { get { return _IfDone; } set { _IfDone = value; } }
        public MyTask()
        {
            this.CreationDate = DateTime.Now;
            IfDone = false;
        }
        public MyTask(string? name) : this()
        {
            this._Name = name;
        }

        public void Finish()
        {
            this.IfDone = true;
        }

        public override string ToString()
        {
            if (this.IfDone)
                return $"[x] {this.Name!.ToString()}";
            else
                return $"[ ] {this.Name!.ToString()}";
        }

        public bool Equals(MyTask? other)
        {
            if (other == null)
                return false;
            return this.Name == other.Name;
        }
    }
}
