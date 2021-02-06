import numpy as np

paper_one = 12.5/15
presentation_one = 13.5/15
paper_two = 14/15 
HW_Blog = np.mean([5/5, 10/10, 7.5/10, 10/10, 10/10])
Participation = 1
Wiki_edit = 14/15
Wiki_pres = 13.5/15
Portfolio = 15/15

print(paper_one*0.1 + presentation_one*0.05 + Wiki_pres*0.1 + Portfolio*0.1 + Wiki_edit*0.15 + paper_two*0.3 + Participation*0.1 + HW_Blog*0.1)
print(0.1 + 0.05 + 0.1 + 0.1 + 0.15 + 0.3 + 0.1 + 0.1)