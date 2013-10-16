# liefert die Menge der 2-fachen der Elementes
# des Schnitts von set1 und set2
def double_intersect(set1,set2):
result = set([])
for x in set1:
if x in set2:
result = result.union(set([2 * x]))
return result
