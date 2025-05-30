import { FaUserPlus } from "react-icons/fa6";
import Logo from "../components/Logo";
import { FaEdit, FaTrash } from "react-icons/fa";

function Adm() {
    return (
        <div className="">
            <div className="bg-white h-16 w-full flex items-center justify-between border border-gray-200 mb-8 px-8">
                <div className="flex items-center gap-2">
                    <Logo className="text-blue-600 text-2xl" />
                </div>
            </div>
            
            <h3 className="text-2xl text-gray-600 flex gap-4 items-center ml-10 mb-4">
                <FaUserPlus /> Lista de usuários
            </h3>
            
            <div className="ml-10 w-9/12 overflow-x-auto">
                <table className="min-w-full bg-white border border-gray-200  shadow-sm">
                    <thead className="bg-gray-100 ">
                        <tr className="grid grid-cols-4  ">
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider border-b border-gray-200">
                                Login
                            </th>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider border-b border-gray-200">
                                Senha
                            </th>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider border-b border-gray-200">
                                Status
                            </th>
                            <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider border-b border-gray-200">
                                Ações
                            </th>
                        </tr>
                    </thead>
                    <tbody className="divide-y divide-gray-200">
                        <tr className="grid grid-cols-4 hover:bg-gray-50">
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900">
                                admin
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                123456
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap">
                                <span className="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                    Ativo
                                </span>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium">
                                <button className="text-blue-600 text-xl hover:text-blue-900 mr-3"><FaEdit/></button>
                                <button className="text-red-600 text-xl hover:text-red-900"><FaTrash/></button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Adm;