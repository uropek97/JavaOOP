﻿namespace FinalProject_Planer
{
    public class MyPurpose
    {
        private string? _Name;
        private List<MyTask>? _Tasks;
        private DateTime _CreationDate;
        private bool _IfDone;

        public string? Name { get { return _Name; } set { _Name = value; } }
        public List<MyTask>? Tasks { get { return _Tasks; } set { _Tasks = value; } }
        public DateTime CreationDate { get { return _CreationDate; } set { _CreationDate = value; } }
        public bool IfDone { get { return _IfDone; } set { _IfDone = value; } }

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
