# Task Tracker
A simple Java console application that demonstrates the usage of core Java Collections (Map, List, Set) by managing tasks with priorities and completion status.
This project is intended for **learning purposes** and as a **portfolio project for junior Java developers**.
---
## Features
- [ ] Add a task with unique ID
- [ ] Prevent duplicate task titles using Set
- [ ] Store tasks using Map
- [ ] Mark task as completed
- [ ] Display all tasks
- [ ] Display incomplete tasks
- [ ] Display HIGH priority tasks
- [ ] Delete a task (optional)
- [ ] Sort tasks by priority (optional)
---
## Data Model
### Task
- id – unique identifier
- title – task name (must be unique)
- priority – LOW / MEDIUM / HIGH
- completed – boolean flag
---
## Collections Used
- [ ] HashMap<Integer, Task> – fast access by task ID
- [ ] HashSet<String> – ensures unique task titles
- [ ] ArrayList<Task> – used for listing and filtering tasks
**Why these collections?**
- Map provides O(1) access by ID
- Set prevents duplicates efficiently
- List allows easy iteration and filtering