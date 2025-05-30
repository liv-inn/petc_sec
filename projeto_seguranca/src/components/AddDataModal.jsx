import Modal from "./Modal";

function AddDataModal({ isOpen, onClose }) {
  if (!isOpen) return null;

  return (
    <Modal isOpen={isOpen} onClose={onClose} portalId="modal-root-1">
      <div className="w-200 bg-white p-4 rounded-lg flex flex-col">
        <Modal.Header>
          <h3 className="text-blue-600 text-2xl">Editar Pet</h3>
          <p className="text-gray-400 mb-2">
            Preecha as informações do pet e seu dono
          </p>
        </Modal.Header>

        <form className="flex gap-8 text-sm">
          <div className="flex-1 flex flex-col gap-4">
            <label className="block">
              Nome do Pet:
              <input
                type="text"
                placeholder="Nome do Pet"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>

            <label className="block">
              Espécie:
              <input
                type="text"
                placeholder="Espécie"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>

            <label className="block">
              Raça:
              <input
                type="text"
                placeholder="Raça"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>
          </div>

          <div className="flex-1 flex flex-col gap-4">
            <label className="block">
              Idade:
              <input
                type="text"
                placeholder="Idade"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>

            <label className="block">
              Dono:
              <input
                type="text"
                placeholder="Nome do Dono"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>

            <label className="block">
              Celular:
              <input
                type="tel"
                placeholder="(XX) XXXXX-XXXX"
                className="mt-1 border border-gray-300 rounded p-2 w-full"
              />
            </label>
          </div>
        </form>

        <button
          type="submit"
          className="w-80 bg-blue-600 text-white rounded p-2 hover:bg-blue-700 transition-colors mt-6 self-center"
        >
          Cadastrar Pet
        </button>
      </div>
    </Modal>
  );
}

export default AddDataModal;
