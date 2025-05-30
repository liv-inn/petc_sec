import { FaEdit, FaTrash } from "react-icons/fa";

function AnimalCard({
  name,
  species,
  breed,
  age,
  owner,
  cel,
  appointmentDate,
  onEditClick,
}) {
  return (
    <div
      className="h-84 w-84 bg-white rounded-sm
         border-gray-200 border shadow-xs
         flex flex-col  p-6 gap-2 "
    >
      <div className="flex justify-between">
        <h3 className="text-blue-600 font-medium text-xl">{name}</h3>
        <div className="flex gap-2">
          <button
            onClick={onEditClick}
            className="hover:bg-blue-100 transition-colors duration-300 rounded"
          >
            <FaEdit className="text-blue-600 border  h-6 w-6 p-1 rounded " />
          </button>

          <button className="hover:bg-blue-100 transition-colors duration-300 rounded ">
            <FaTrash className="text-blue-600 border  h-6 w-6 p-1 rounded" />
          </button>
        </div>
      </div>

      <div className="flex gap-2">
        <p className="text-sm text-gray-500">{species} •</p>
        <p className="text-sm text-gray-500 ">{breed}</p>
      </div>
      <div className="flex justify-between items-center   text-sm">
        <p className="text-gray-500">Idade:</p>
        <p className="bg-gray-300 rounded-lg p-1.5 text-gray-700"> {age}</p>
      </div>

      <div className="text-sm  flex flex-col gap-2">
        <p className="mt-2">Dono: </p>
        <p className="text-gray-600 "> {owner}</p>
        <p className="text-gray-600 mb-4">{cel}</p>
        <div className="border border-gray-200 mb-2"></div>
        <p> Última Consulta: </p>
        <p className="text-gray-600"> {appointmentDate}</p>
      </div>
    </div>
  );
}

export default AnimalCard;
