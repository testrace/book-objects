function Lecture(name, scores) {
  this.name = name;
  this.scores = scores;
}

Lecture.prototype.stats = () => {
  return "Name: " + this.name + ", Evaluation Method: " + this.getEvaluationMethod();
};

Lecture.prototype.getEvaluationMethod = () =>  {
  return "Pass or Fail";
};
