select rm.fechaIngreso, ma.nombre
from mascota ma
inner join registro_mascota
as rm
where rm.idMascota= :id and ma.id= :id;