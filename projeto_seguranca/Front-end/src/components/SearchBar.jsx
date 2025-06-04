import { useState } from "react";
import { FaSearch } from "react-icons/fa";

function SearchBar() {
  const [searchTerm, setSearchTerm] = useState("");

  return (
    <div className="relative w-250 ml-24 mt-8 ">
      <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
        <FaSearch className="text-gray-400" />
      </div>
      <input
        type="text"
        placeholder="Buscar pet por nome..."
        className=" bg-white pl-10 pr-4 py-1.5 w-full h-12 text-sm border border-gray-200 rounded focus:outline-none focus:border-gray-300 "
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
    </div>
  );
}

export default SearchBar;
